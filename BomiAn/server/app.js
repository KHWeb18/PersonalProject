const express = require('express');
const app = express();
const bcrypt = require('bcrypt')
const cors = require('cors');

const corsOptions = {
    origin: "http://localhost:8080",
    credentials: true
}

app.use(express.json());
app.use(express.urlencoded({
  extended: true
}));

app.use(cors(corsOptions));
const server = app.listen(3000, () => {
    console.log('Server started. Port 3000.');
});

const db = {
    database: "ifyou",
    connectionLimit: 10,
    host: 3306,
    user: "root",
    password: "khweb@123"
};

const dbPool = require('mysql').createPool(db);


app.post('/api/signUp', function (req, res) {
  const email = req.body.user.email
  const nickname = req.body.user.nickname
  const password = req.body.user.password
        dbPool.query(
            `select * from users where user_email = "${email}"`,
            async (err, row) => {
                if (row[0] == undefined) {
                    const salt = bcrypt.genSaltSync();
                    const encryptedPassword = bcrypt.hashSync(password, salt);
                    await dbPool.query(
                        `insert into users (user_email, user_nickname, user_pw) values ("${email}", "${nickname}", "${encryptedPassword}")`,
                        function (err, row2) {
                            if (err) 
                                throw err;
                            }
                        );
                    res.json({success: true, message: 'Sing Up Success!'})
                } else {
                    res.json({success: false, message: 'Sign Up Failed Please use anoter ID'});
                };
            }
        );
});

app.post('/api/signIn', function (req, res) {
    const email = req.body.user.email
    const password = req.body.user.password
        dbPool.query(
            `select user_email, user_pw, user_nickname, id from users where user_email = "${email}"`,
            function (err, row) {
                if (err) {
                    res.json(
                        {success: false, message: 'Login failed please check your id or password'}
                    )
                }
                if (row[0] !== undefined && row[0].user_email == email) {
                    bcrypt.compare(password, row[0].user_pw, function (err, res2) {
                        if (res2) {
                            res.json({
                                success: true,
                                message: 'Login Successful!',
                                userInfo: {
                                    no: row[0].id,
                                    email: row[0].user_email,
                                    nickname: row[0].user_nickname
                                }
                            })
                        } else {
                            res.json(
                                {success: false, message: 'Login failed please check your id or password'}
                            )
                        }
                    })
                }
            }
        )
})

app.post('/api/insertTopic',function (req, res) {
        const { user_id, type, topic, op1, op2, content } = req.body.board
            dbPool.query(`insert into boards (user_id, type, topic, op1, op2, content) values(
              ${user_id}, ${type}, "${topic}", "${op1}", "${op2}", "${content}" )`, function (err, row) {
                    res.send('ok')
                    if (err) 
                        throw err;
                    }
                )
    }
)

app.get('/api/getBoards', function (req, res) {
    dbPool.query(`select b.*, u.user_nickname from boards as b inner join users as u on u.id = b.user_id`, function (err, rows) {
        if (err) 
            throw err;
        res.send(rows)
    })
})

app.get('/api/getBoardDetail/:id', function (req, res) {
    let id = parseInt(req.params.id, 10)
    dbPool.query(`select b.*, u.user_nickname from boards as b inner join users as u on u.id = b.user_id and b.id = ${id}`, function(err, row) {
      res.send(row[0])
    })
})

app.post(`/api/insertComment`, function (req, res) {
    let {b_no, u_no, comment, icon} = req.body.comment
        dbPool.query(`insert into comments (b_no, u_no, comment, icon) values (${b_no}, ${u_no}, "${comment}", "${icon}")`,
            function (err, row) {
                if (err) 
                    throw err
                res.send('ok')
            }
        )
})

app.get(`/api/getCommentsList/:id`, function (req, res) {
    let id = parseInt(req.params.id, 10)
    dbPool.query(`select  c.*, u.user_nickname from comments as c inner join users as u on c.b_no = ${id} and u.id = c.u_no`,
        function (err, rows) {
            if (err) 
                throw err;
            res.send(rows)
        }
    )
})

app.post(`/api/vote/option1/`, function (req, res) {
    const b_no = req.body.vote.b_no
    const u_no = req.body.vote.u_no
        dbPool.query(`select * from check_vote where u_no = ${u_no} and b_no = ${b_no}`,
            function (err, row) {
                if (row[0] == undefined) {
                    dbPool.query(`insert into check_vote (u_no, b_no) values (${u_no}, ${b_no})`)
                    dbPool.query(`update boards set op1_cnt=op1_cnt+1, all_cnt=all_cnt+1 where id = ${b_no}`
                    )
                    res.json({success: true, message: 'Vote success!'})
                } else {
                    res.json({success: false, message: 'You have already voted.'})
                }
            }
        )
});

app.post(`/api/vote/option2/`, function (req, res) {
  const b_no = req.body.vote.b_no
  const u_no = req.body.vote.u_no
      dbPool.query(`select * from check_vote where u_no = ${u_no} and b_no = ${b_no}`,
          function (err, row) {
              if (row[0] == undefined) {
                  dbPool.query(`insert into check_vote (u_no, b_no) values (${u_no}, ${b_no})`)
                  dbPool.query(`update boards set op2_cnt=op2_cnt+1, all_cnt=all_cnt+1 where id = ${b_no}`
                  )
                  res.json({success: true, message: 'Vote success!'})
              } else {
                  res.json({success: false, message: 'You have already voted.'})
              }
          }
      )
});


app.post(`/api/deleteComment/:id`, function (req, res) {
    let id = parseInt(req.params.id, 10)
    dbPool.query(`delete from comments where id = ${id}`, function (err, res2) {
        res.send('delete Success!')
    })
})

app.post(`/api/changeNickname/:id`, function (req, res) {
    let nickname = req.body.nickname
    let id = parseInt(req.params.id, 10)
    dbPool.query(`update users set user_nickname = "${nickname}" where id = ${id}`,
        function (err, row2) {
            dbPool.query(`select * from users where id = ${id}`, function (err, row) {
                if (err) throw err
                res.json({
                    userInfo: {
                        no: row[0].id,
                        email: row[0].user_email,
                        nickname: row[0].user_nickname
                    },
                    message: 'change nickname success!'
                })
            })
        }
    )
})

app.get(`/api/getUserBoards/:id`, function (req, res) {
    let id = parseInt(req.params.id, 10)
    dbPool.query(
        `select * from boards where user_id = ${id}`,
        function (err, rows) {
            if (err) 
                throw err;
            res.send(rows)
        }
    )
})

app.post(`/api/deleteMyBoard/:id`, function (req, res) {
    let id = parseInt(req.params.id, 10)
    dbPool.query(`delete from boards where id = ${id}`, function (err, res2) {
        if (err) 
            throw err;
          res.send('ok')
        }
    )
})

app.post(`/api/updateMyBoard`,function (req, res) {
        const { type, topic, op1, op2, content, id} = req.body.board
            dbPool.query(`update boards set type = ${type}, topic = "${topic}", op1 = "${op1}", op2 = "${op2}", content = "${content}" where id = ${id}`,
            function (err, res2) {
                if (err) throw err;
                res.send('ok')
              }
        )
    }
)

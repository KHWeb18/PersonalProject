import Vue from 'vue'
import { extend, ValidationObserver, ValidationProvider } from 'vee-validate'
import { max, required, numeric, digits, email, confirmed } from 'vee-validate/dist/rules'

extend('email', {
  ...email,
  message: '{_field_}는 잘못입력된 주소입니다.'
})

extend('max', {
  ...max,
  message: '{_field_}는 {length}자를 초과할 수 없습니다'
}
)
extend('required', {
  ...required,
  message: '{_field_}는 필수 값입니다.'
})
extend('numeric', {
  ...numeric,
  message: '{_field_}는 숫자로만 구성되어야합니다.'
})
extend('digits', {
  ...digits,
  message: '{_field_}필드는 {length}자리여야 합니다.'
})
extend('confirmed', {
  ...confirmed,
  message: '{_field_}필드는 일치하지 않습니다.'
})

Vue.component('ValidationObserver', ValidationObserver)
Vue.component('ValidationProvider', ValidationProvider)

import walk from "../assets/walk.json"
import bike from "../assets/bike.json"
import motorcycle from "../assets/cityMotorcycle.json"
import car from "../assets/car.json"

export default {
    // walk
    walk: walk,
    selectedWalk: null,
    // bike
    bike: bike,
    selectedBike: null,
    // motorcycle
    motorcycle: motorcycle,
    selectedMotorcycle: null,
    // car
    car: car,
    selectedCar: null,
    // session
    session: [],
    // board
    boards: [],
    board: null,

    comments: [],
    comment: null,

    replies: [],
    reply: null,

    member: null,
}

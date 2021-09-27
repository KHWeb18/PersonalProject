export default {
    filteredTodoItems (state) {
        if (!state.filter) {
            return state.todoItems
        }
    },
    randomFromSpring (state) {
        return state.randomFromSpring
    },
    getSession (state) {
        return state.session
    }
}
package ru.hse.software.construction.mvp

class UserPresenter(private val userView: UserView, private val userRepository: UserRepository) {
    fun onViewCreated() {
        try {
            val users = userRepository.getUsers()
            userView.showUsers(users)
        } catch (e: Exception) {
            userView.showError(e.message ?: "An error occurred")
        }
    }
}
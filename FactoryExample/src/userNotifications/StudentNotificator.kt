package userNotifications

import users.*

class StudentNotificator: UserNotificator {
    override fun notify(user: User) {
        if (user is Student) {
            println("Sending email to ${user.email}")
            //TODO send email
        }
    }
}
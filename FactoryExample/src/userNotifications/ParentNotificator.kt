package userNotifications

import users.*

class ParentNotificator: UserNotificator {
    override fun notify(user: User) {
        if (user is Parent) {
            println("Sending email to ${user.email}")
            //TODO send email
        }
    }
}
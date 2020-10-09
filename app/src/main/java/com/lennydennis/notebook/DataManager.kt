package com.lennydennis.notebook

class DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourse()
    }

    private fun initializeCourse() {
        val course = CourseInfo("cs","Computer Science")
        courses.set(course.courseId, course)
    }
}
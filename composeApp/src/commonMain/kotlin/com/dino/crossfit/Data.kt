package com.dino.crossfit

object Data {
    enum class OneRepMax(val value: Int) {
        SNATCH(135),
        CLEAN(175),
        JERK(165),
        DEADLIFT(265),
        BACK_SQUAT(265),
        BENCH_PRESS(165),
        SHOULDER_PRESS(115),
    }

    enum class Week(
        val weekSet: List<WeekSet>,
    ) {
        WEEK_1(
            listOf(
                WeekSet(0.65, 5),
                WeekSet(0.75, 5),
                WeekSet(0.85, 5),
            )
        ),
        WEEK_2(
            listOf(
                WeekSet(0.70, 3),
                WeekSet(0.80, 3),
                WeekSet(0.90, 3),
            )
        ),
        WEEK_3(
            listOf(
                WeekSet(0.75, 5),
                WeekSet(0.85, 3),
                WeekSet(0.95, 1),
            )
        ),
    }

    data class WeekSet(
        val tm: Double,
        val reps: Int,
    )
}

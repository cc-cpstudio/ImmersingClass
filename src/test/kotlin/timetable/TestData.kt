package timetable

val jsoned_timetable = """
    {
        "subjects": [
            {
                "id": 0,
                "name": "Math",
                "simple": "Mth",
                "outside": false,
                "teacher": "MrsSmith"
            },
            {
                "id": 1,
                "name": "English",
                "simple": "Eng",
                "outside": false,
                "teacher": "MrJohnson"
            },
            {
                "id": 2,
                "name": "Physics",
                "simple": "Phy",
                "outside": false,
                "teacher": "MrsJones"
            },
            {
                "id": 3,
                "name": "Chemistry",
                "simple": "Chm",
                "outside": false,
                "teacher": "MrBrown"
            },
            {
                "id": 4,
                "name": "PE",
                "simple": "PE",
                "outside": true,
                "teacher": "MrsTaylor"
            },
        ],
        "timelines": [
            {
                "id": 0,
                "nodes": [
                    {
                        "id": 0,
                        "type": "lesson",
                        "start": "08:30:00",
                        "end": "09:30:00",
                        "config": {}
                    },
                    {
                        "id": 1,
                        "type": "break",
                        "start": "09:30:00",
                        "end": "09:40:00",
                        "config": {}
                    }
                    {
                        "id": 2,
                        "type": "lesson",
                        "start": "09:40:00",
                        "end": "10:40:00",
                        "config": {}
                    }
                ]
            },
            {
                "id": 1,
                "nodes": [
                    {
                        "id": 0,
                        "type": "lesson",
                        "start": "08:30:00",
                        "end": "09:30:00",
                        "config": {}
                    }
                ]
            }
        ],
        "lessons": [
            {
                "id": 0,
                "timeline": 0,
                "workWeekday": "MONDAY",
                "workWeek": {
                    "first": 1,
                    "second": 1
                },
                "nodes": [
                    {
                        "id": 0,
                        "node: 0,
                        "lesson": 0
                    },
                    {
                        "id": 1,
                        "node: 2,
                        "lesson": 1
                    }
                ]
            },
            {
                "id": 1,
                "timeline": 0,
                "workWeekday": "TUESDAY",
                "workWeek": {
                    "first": 1,
                    "second": 2
                },
                "nodes": [
                    {
                        "id": 0,
                        "node: 0,
                        "lesson": 2
                    },
                    {
                        "id": 1,
                        "node: 2,
                        "lesson": 3
                    }
                ]
            },
            {
                "id": 2,
                "timeline": 0,
                "workWeekday": "TUESDAY",
                "workWeek": {
                    "first": 2,
                    "second": 2
                },
                "nodes": [
                    {
                        "id": 0,
                        "node: 0,
                        "lesson": 4
                    },
                    {
                        "id": 1,
                        "node: 2,
                        "lesson": 3
                    }
                ]
            },
            {
                "id": 3,
                "timeline": 1,
                "workWeekday": "WEDNESDAY",
                "workWeek": {
                    "first": 1,
                    "second": 1
                },
                "nodes": [
                    {
                        "id": 0,
                        "node: 0,
                        "lesson": 2
                    }
                ]
            }
        ]
    }
""".trimIndent()
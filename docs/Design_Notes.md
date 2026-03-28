# Design Notes

## Why ArrayList?
I used ArrayList because it allows dynamic resizing and is easier to use compared to arrays.  helps in storing and managing data like students, courses, and enrollments.

## Use of Static
I used static variables in IdGenerator to generate unique IDs for students, courses, and enrollments. This ensures no duplicate IDs and no need to create objects.

## Use of Inheritance
I created a base class Person and extended it in Student. This avoids code duplication and improves reusability of common fields like name and email.
package _207_Course_Schedule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Course> courses = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      courses.add(new Course(i));
    }
    for (int[] prerequisite : prerequisites) {
      courses.get(prerequisite[0]).from.add(courses.get(prerequisite[1]));
    }

    while (true) {
      List<Course> takeCourse = courses.stream().filter(course -> course.from.isEmpty()).toList();
      courses.removeAll(takeCourse);
      takeCourse.forEach(course -> courses.forEach(course1 -> course1.from.remove(course)));
      if (takeCourse.isEmpty()) {
        break;
      }
    }
    return courses.isEmpty();
  }

  private static class Course {
    int courseNum;
    Set<Course> from;

    public Course(int courseNum) {
      this.courseNum = courseNum;
      this.from = new HashSet<>();
    }
  }
}
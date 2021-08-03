package repository

import cats.Applicative
import cats.syntax.applicative._
import entity.Task

import java.util.UUID
import javax.inject.Inject

class TaskRepository[F[_] : Applicative] @Inject()() {
  def create(task: Task): F[Unit] = (tasks = task :: tasks).pure[F]

  def nextTaskId(): F[String] = UUID.randomUUID().toString.pure[F]


  private[this] var tasks = List(
    Task(UUID.randomUUID().toString, "wake up", "wake you up"),
    Task(UUID.randomUUID().toString, "stand up", "read a lot"),
    Task(UUID.randomUUID().toString, "shut up", "keep silent")
  )

  def all(): F[List[Task]] = tasks.pure[F]

}

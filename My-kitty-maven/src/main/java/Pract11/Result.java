package Pract11;

sealed interface Result permits Success, Failure {}

record Success(String data) implements Result{}
record Failure(String error) implements Result{}

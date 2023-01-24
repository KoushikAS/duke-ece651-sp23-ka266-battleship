package edu.duke.ka266.battleship;

public class Coordinate {

  private final int row;
  private final int column;

  private void parseCoordinate() {

    if (this.row < 0 || this.row >= 26 || this.column < 0 || this.column > 10) {
      throw new IllegalArgumentException(
          "Cordinate must fit the Board (must be no larger than 10x26), but is " + this.row + "x" + this.column);
    }

  }

  Coordinate(String descr) {

    char rowLetter = descr.toUpperCase().charAt(0);
    if (rowLetter < 'A' || rowLetter > 'Z') {
      throw new IllegalArgumentException("Row character should be an Aplha character but is " + descr.charAt(0));
    }

    this.row = (int) rowLetter - 'A';

    String columnString = descr.substring(1);
    try {

      this.column = Integer.parseInt(columnString);

    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Row character should be an Aplha character but is " + descr.charAt(0));
    }
    this.parseCoordinate();

  }

  Coordinate(int r, int c) {
    this.row = r;
    this.column = c;
    this.parseCoordinate();
  }

  public int getRow() {
    return this.row;
  }

  public int getColumn() {
    return this.column;
  }

  @Override
  public boolean equals(Object o) {
    if (o != null && o.getClass().equals(getClass())) {
      Coordinate c = (Coordinate) o;
      return row == c.row && column == c.column;
    }
    return false;
  }

  @Override
  public String toString() {
    return "(" + row + ", " + column + ")";
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }

}
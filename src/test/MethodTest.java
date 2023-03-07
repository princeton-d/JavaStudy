package test;

public class MethodTest {

  public static void main(String[] args) {
    Tv tv = new Tv();
    Audio audio = new Audio();
    Buyer buyer = new Buyer();
    buyer.buy(tv);
    buyer.buy(audio);
    System.out.println(buyer.getMoney());
    System.out.println(buyer.getBonusPoint());
  }
}

class Product {
  private int price;
  private int bonusPoint;

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getBonusPoint() {
    return bonusPoint;
  }

  public void setBonusPoint(int bonusPoint) {
    this.bonusPoint = bonusPoint;
  }
}

class Tv extends Product {
  private int price = 100;
  private int bonusPoint = 10;

  @Override
  public int getPrice() {
    return price;
  }

  @Override
  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public int getBonusPoint() {
    return bonusPoint;
  }

  @Override
  public void setBonusPoint(int bonusPoint) {
    this.bonusPoint = bonusPoint;
  }
}

class Audio extends Product {
  private int price = 50;
  private int bonusPoint = 5;

  @Override
  public int getPrice() {
    return price;
  }

  @Override
  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public int getBonusPoint() {
    return bonusPoint;
  }

  @Override
  public void setBonusPoint(int bonusPoint) {
    this.bonusPoint = bonusPoint;
  }
}

class Buyer {
  private int money = 10000;
  private int bonusPoint = 0;

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public int getBonusPoint() {
    return bonusPoint;
  }

  public void setBonusPoint(int bonusPoint) {
    this.bonusPoint = bonusPoint;
  }

  public void buy(Product product) {
    this.setMoney(this.getMoney() - product.getPrice());
    this.setBonusPoint(this.getBonusPoint() + product.getBonusPoint());
  }
}

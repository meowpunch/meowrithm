package company.amazon;

/*
   https://leetcode.com/discuss/interview-question/233869/Design-Amazon-Locker-system
   - Users should be able to use a code to open a locker and pick up a package
   - Delivery guy should be able to find an "optimal" locker for a package

   https://techmockinterview.com/blog/2022/08/12/logical-and-maintainable-coding-interview-amazon-locker/
   - Interviewer: An Amazon pickup location has various lockers for packages to be dropped off and picked up.
   We have both packages and lockers of varying sizes. Model the lockers, packages,
   and pickup location and implement an algorithm to find the best possible empty locker for a given package efficiently.


   Locker
   Package

   User Journey
   - In checkout page to pay and order the item, user choose one of locker hub
       - User should see locker hubs that has avaialble lockers for the package at the moment
       - Then the avaiable locker should be reserved for the
       - If payment is completed and order is started, the available locker should be occupied for certain time
         (from estimated delivered datetime to maximum datetime that locker can hold the item, 7 days)
       - If customers take their item in 7 days after delivered, the locker should be avaiable again
       - Otherwise, item refund should be initiated

   Order service - maintain status of order from payment started to item delivered
     - payment data
     - Package data
   Payment Service - checkout and pay in
   Locker Service



*/

class PackageFinder {

  //  List<>
}

enum PackageSize {
  S,
  M,
  X,
  XL
}

enum LockerSize {
  S,
  M,
  X,
  XL
}

record Package(long id, PackageSize size) {}

class AmazonLockerHub {

  public static void main(String[] args) {}
}

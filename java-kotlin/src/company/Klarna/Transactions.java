package company.Klarna;

import java.util.HashMap;
import java.util.List;

public class Transactions {

  public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
    final var totalAmountByUserId = new HashMap<String, Integer>();
    return transactions.stream()
        .map(Transactions::mapToTransaction)
        .filter(transaction -> {
          var totalAmount = totalAmountByUserId.getOrDefault(transaction.userId, 0) + transaction.amount;
          if (totalAmount > creditLimit) {
            return true;
          } else {
            totalAmountByUserId.put(transaction.userId, totalAmount);
            return false;
          }
        })
        .map(Transaction::transactionId)
        .toList();
  }

  private static Transaction mapToTransaction(String transaction) {
    var parts = transaction.split(",");
    return new Transaction(generateUserId(parts[0], parts[1], parts[2]), Integer.parseInt(parts[3]), parts[4]);
  }

  private static String generateUserId(String firstName, String lastName, String email) {
    return String.format("%s-%s-%s", firstName, lastName, email);
  }

  private record Transaction(String userId, int amount, String transactionId) {

  }
}
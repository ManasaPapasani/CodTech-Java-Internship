import java.util.*;

public class RecommendationSystem {

    public static void main(String[] args) {

        // Sample product ratings (User -> Product -> Rating)
        Map<String, Map<String, Integer>> userRatings = new HashMap<>();

        // User A ratings
        Map<String, Integer> userA = new HashMap<>();
        userA.put("Laptop", 5);
        userA.put("Phone", 3);
        userRatings.put("UserA", userA);

        // User B ratings
        Map<String, Integer> userB = new HashMap<>();
        userB.put("Laptop", 4);
        userB.put("Tablet", 5);
        userRatings.put("UserB", userB);

        // User C ratings
        Map<String, Integer> userC = new HashMap<>();
        userC.put("Phone", 5);
        userC.put("Tablet", 4);
        userRatings.put("UserC", userC);

        String targetUser = "UserA";

        System.out.println("Recommendations for " + targetUser + ":");

        recommendProducts(userRatings, targetUser);
    }

    public static void recommendProducts(Map<String, Map<String, Integer>> userRatings, String targetUser) {

        Map<String, Integer> targetRatings = userRatings.get(targetUser);
        Set<String> recommended = new HashSet<>();

        for (String otherUser : userRatings.keySet()) {

            if (!otherUser.equals(targetUser)) {

                Map<String, Integer> otherRatings = userRatings.get(otherUser);

                for (String product : otherRatings.keySet()) {

                    if (!targetRatings.containsKey(product)
                            && otherRatings.get(product) >= 4
                            && !recommended.contains(product)) {

                        System.out.println("Recommended: " + product + " (based on similar users)");
                        recommended.add(product);
                    }
                }
            }
        }
    }
}
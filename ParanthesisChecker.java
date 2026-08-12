package programs;

import java.util.*;

public class ParanthesisChecker {
    public static void main(String args[]) {
        String input = "[()()]{}";
        System.out.println(isBalanced(input));
    }
    public static boolean isBalanced(String s) {
        // code here
        Map<String,String> caseMapping = new HashMap<>();
        caseMapping.put(")", "(");
        caseMapping.put("}", "{");
        caseMapping.put("]", "[");

        Stack<String> cases = new Stack<>();
        for(int i=0; i < s.length();i++){
            String substr = String.valueOf(s.charAt(i));
            if(!caseMapping.containsKey(substr)){
                cases.add(substr);
            } else {
                try {
                    String openCase = cases.pop();
                    String closeCase = caseMapping.get(substr);
                    if (!openCase.equals(closeCase)) {
                        return false;
                    }
                }catch (Exception e){
                    return false;
                }
            }

        }

        if(cases.size() > 0){
            return false;
        }
        return true;

    }
}

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length() || t.equals("")){
            return "";
        }
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character,Integer> window = new HashMap<>();
        int have = 0, need = charCount.size();
        int l = 0;
        int minStart = 0, minLength = Integer.MAX_VALUE;
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            window.put(ch, window.getOrDefault(ch,0)+1);

            // If this character's required frequency is satisfied
            if(charCount.containsKey(ch) && charCount.get(ch).equals(window.get(ch))){
                have++;
            }

            // Window is valid
            while(have == need){
                // Update minimum window
                if((r-l+1) < minLength){
                    minLength = (r-l+1);
                    minStart = l;
                }

                //Shrink the window
                //At the same time we cannot remove the entire key itself the key may be A:2 
                window.put(s.charAt(l), window.get(s.charAt(l))-1);

                //Check if Window became invalid for this character
                //Here the second condition is to sometime there may be extra characters eg need A:1 but had window A:2 in that case we not decrement have
                if(charCount.containsKey(s.charAt(l)) && window.getOrDefault(s.charAt(l),0) < charCount.get(s.charAt(l))){
                    have--;
                }

                //To really shirnk the window you need to increment the left
                l++;
            }
        }
        if(minLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minStart, minStart+minLength);
    }
}
//Time- O(n+m)
//Space- O(n+m)
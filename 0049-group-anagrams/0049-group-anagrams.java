//Refer leetcode notes
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {         
        HashMap<String,List<String>>  anagramGroups = new HashMap<>();

        for(String str : strs){
            int freq[] = new int[26];

            for(char ch : str.toCharArray()){
                freq[ch-'a']++;
            }

            //Now we need a stringbuilder to represent this freq array - why not use the array itself is explained in the leetcode notes
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append('#');
                sb.append(freq[i]);
            }

            if(!anagramGroups.containsKey(sb.toString())){
                anagramGroups.put(sb.toString(), new ArrayList<>());
            }
            //Add the value to that arraylist - accordingly to the key
            anagramGroups.get(sb.toString()).add(str);
            //Here i never used put() because we used the references and key exisit in hashmap
        }

        return new ArrayList<>(anagramGroups.values());
    }
}
//Time- O(n.k)
//Space- O(n.k)
//n - no of strings in strs, k - max len of string in input array 
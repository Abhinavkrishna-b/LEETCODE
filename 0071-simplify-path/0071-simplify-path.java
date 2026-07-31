class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        //If s="/a//b" then component = ["a","","b"]
        Stack<String> st = new Stack<>();

        for(String item : components){
            if(item.equals("") || item.equals(".")){
                continue;
            }
            if(item.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(item);
            }
        }

        //Buil the result string with '/' seperated 
        //Stack is LIFO so we need to add the poped string in front so i use String instead of String Builder
        String result = "";
        while(!st.isEmpty()){
            result = "/" + st.pop() + result;
        }

        if(result.length() == 0){
            return "/";
        }      
        return result;
    }
}
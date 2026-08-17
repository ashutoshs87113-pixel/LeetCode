class Solution {

    public boolean isSame(char a, char b){
        if(a=='[' && b==']') return true;
        if(a=='{' && b=='}') return true;
        if(a=='(' && b==')') return true;
        return false;
    }
    public boolean isOpen(char a){
        if(a == '[' || a == '{' || a == '(') return true;
        return false;
    }
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(isOpen(ch)) st.push(ch);

            else{
                if(st.size() == 0) return false;

                char top = st.peek();
                if(isSame(top, ch)) st.pop();
                else{
                    return false;
                }
            }
        }
        return (st.size() == 0 );
    }
}
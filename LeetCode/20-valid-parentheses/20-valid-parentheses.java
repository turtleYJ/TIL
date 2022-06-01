class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        boolean Ok = true;
        
        
        for(int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            switch (c) {
            case '(':
            case '{':
            case '[':
                stack.add(c);
                    
                break;
            case ')':
                if(stack.size() > 0 && stack.peek() == '(') {
                    stack.pop();
                } else {
                    Ok = false;
                }
                
                break;
            case '}':
                if(stack.size() > 0 && stack.peek() == '{') {
                    stack.pop();
                } else {
                    Ok = false;
                }
                    
                break;
            case ']':
                if(stack.size() > 0 && stack.peek() == '[') {
                    stack.pop();
                } else {
                    Ok = false;
                }
                    
                break;
            }
        }
        
        if(stack.size() != 0) {
        	Ok = false;
        }
            
            return Ok;
    }
}
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        StringBuilder res=new StringBuilder();
        StringBuilder key=new StringBuilder();
        boolean flag=false;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                key=new StringBuilder();
                flag=true;
            }else if(ch==')'){
                res.append(map.getOrDefault(key.toString(),"?"));
                flag=false;
            }else{
                if(flag) key.append(ch);
                else res.append(ch);
            }
        }
        return res.toString();
    }
}
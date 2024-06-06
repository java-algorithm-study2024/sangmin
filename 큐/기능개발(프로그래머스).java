import java.util.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Work> q = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0; i< progresses.length; i++){
            q.offer(new Work(progresses[i],speeds[i]));
        }
    
        int count = 0;
        
            for(int i=1;;i++) {
                
                if(q.isEmpty()){
                    break;
                }
                
                Work work = q.peek();
                
                if(work.done + work.speed*i < 100) {
                    continue;
                } else {
                    while(true) {
                        
                        if(q.isEmpty()){
                            break;
                        }
                        
                        Work doneWork = q.peek();
                        if(doneWork.done + doneWork.speed*i >= 100){
                            q.poll();
                            count++;
                        } else {
                            break;
                        }
                    }
                }
                
                if(count != 0) {
                    answer.add(count);
                }
                count = 0;
            }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class Work {
        
        private int done;
        private int speed;
        
        public Work(int done, int speed) {
            this.done = done;
            this.speed = speed;
        }
        
    }
}

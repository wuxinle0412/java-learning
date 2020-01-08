package cn.unipus.thread.threadlocal;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/1/7 21:57
 */
public class ThreadLocalDemo {

  private static ThreadLocal<Index> index = new ThreadLocal<Index>(){
    @Override
    protected Index initialValue() {
      return new Index();
    }
  };

  private static class Index {
    private int num;

    public void incr() {
      num++;
    }
  }

  public static void main(String[] args) {
    for(int i=0; i<5; i++){
      new Thread(new Runnable() {
        public void run() {
          Index local = index.get();
          local.incr();
          System.out.println(Thread.currentThread().getName() + " " + index.get().num);
        }
      }, "thread_" + i).start();
    }

  }
}

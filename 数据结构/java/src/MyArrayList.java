import java.util.Arrays;

public class MyArrayList {
    private int[] elem;
    private int usedSize;

    public MyArrayList() {
        this.elem = new int[5];
    }

    public MyArrayList(int capacity) {
        this.elem = new int[capacity];
    }


    //打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
    }
    public boolean isFull() {
        if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }
    //扩容
    public void resize() {
        this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
    }
    //在 pos 位置新增元素
    public void add(int pos,int data) {
        //顺序表是否满
        if(isFull()) {
            resize();//进行扩容
        }
        //pos是否合法
        if(pos < 0 || pos > usedSize) {
            System.out.println("pos位置不合法！");
            return;
        }
        //移动元素
        for(int i = this.usedSize - 1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    //判定是否包含某个元素
    public boolean contains(int toFind) {
        for(int i = 0 ; i <= usedSize - 1 ; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    //查找某个元素对应的位置
    public int search(int toFind) {
        for(int i = 0 ; i <= usedSize - 1; i++) {
            if(contains(toFind)) {
                return i;
            }
        }
        return -1;
    }
    //获取 pos 位置元素
    public int getPos(int pos) {
        if(pos < 0 || pos >= usedSize) {
            System.out.println("pos 位置不合法！");
            return -1;
        }
        return this.elem[pos];
    }
    //给 pos 位置的元素修改为为value
    public void setPos(int pos,int value) {
        if(pos < 0 || pos >= usedSize) {
            System.out.println("pos 位置不合法！");
            return;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字 key
    public void remove(int key) {
        int index = search(key);
        if(index == -1) {
            System.out.println("not find!");
            return;
        }
        for (int i = index; i < this.usedSize - 1; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.usedSize--;
    }
    //获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    //清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}

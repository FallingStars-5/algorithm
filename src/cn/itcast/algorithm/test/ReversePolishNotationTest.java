package cn.itcast.algorithm.test;

import cn.itcast.algorithm.linear.Stack;

/**通过栈的思想计算逆波兰表达式的值
 * @author 落星
 */
public class ReversePolishNotationTest {

    public static void main(String[] args) {
        //中缀表达式3*(17-15)+18的逆波兰表达式如下
        String[] notation = {"3","17","15","-","*","18","6","/","+"};
        int result = calculate(notation);
        System.out.println("逆波兰表达式的结果为:"+result);
    }

    /**
     * @param notation 逆波兰表达式的数组表示方式
     * @return 逆波兰表达式的计算结果
     */
    private static int calculate(String[] notation) {

        //1.定义一个栈，用来存储操作数
        Stack<Integer> oprands = new Stack<>();

        //2.从左往右遍历逆波兰表达式，得到每一个元素
        for (int i=0;i< notation.length;i++){
            String curr = notation[i];

            //3.判断当前元素是运算符还是操作数

            Integer o1,o2;
            switch (curr){
                //4.运算符，从栈中弹出两个操作数，完成运算，运算完的结果再压入栈中
                case "+":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    oprands.push(o2+o1);
                    break;
                case "-":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    oprands.push(o2-o1);
                    break;
                case "*":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    oprands.push(o2*o1);
                    break;
                case "/":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    oprands.push(o2/o1);
                    break;
                default:
                    //5.操作数，把该操作数放入栈中
                    try{
                        oprands.push(Integer.valueOf(curr));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
            }
        }

        //6.得到栈中最后一个元素，就是逆波兰表达式的结果

        return oprands.pop();
    }

}

public class Runner
{
    public static void main(String[] args)
    {
        StringMethods test = new StringMethods();
        test.unusualHello("Ron");
        System.out.println(test.stringRipper("something"));
        System.out.println(test.evenFooBar("foobarfoobarfoo"));
        System.out.println(test.sumString("Hi 7 there are 9 or 8 numbers in this String"));
        System.out.println(test.decode(" h e l l o   w o r l d "," 6 4 0 5 3 7 2 "));
    }
}
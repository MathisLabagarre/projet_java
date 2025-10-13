public class FooRPL{
    public static void main(String[] args){
		PileRPL pile = new PileRPL();
		ObjRPL obj1 = new ObjRPL(13, 15);
		ObjRPL obj2 = new ObjRPL(27, 12);
        System.out.println(obj1.objSize());
		pile.stack(obj1);
		pile.stack(obj2);
		pile.stackPrint();
		pile.add();
	}
}
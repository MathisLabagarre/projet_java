public class FooRPL{
    public static void main(String[] args){
		PileRPL pile = new PileRPL();
		ObjRPL obj1 = new ObjRPL(13, 15);
		ObjRPL obj2 = new ObjRPL(27255555, 12);
		ObjRPL obj3 = new ObjRPL(27, 12);
		ObjRPL obj4 = new ObjRPL(27, 12);

		pile.stack(obj1);
		pile.print();
		pile.stack(obj2);
		pile.print();
		pile.stack(obj3);
		pile.print();
		pile.stack(obj4);
		pile.print();

		pile.add();
		pile.print();
	}
}
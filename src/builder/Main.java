package builder;

import static builder.MyPizza.Size.*;
import static builder.Pizza.Topping.*;

public class Main {

	public static void main(String[] args) {

		// 必要なオプションについてのみフィールドに値を持たせてインスタンス化することができる
		NutritionFats cocaColaFats = new NutritionFats.Builder(240, 8).
				calories(100).sodium(35).carbohydrate(27).build();

		// 例えば、通常のコンストラの場合では、その時必要ではないフィールドにも値を渡してやる必要がある
		// 以下、オプションでcaloriesのみ値が必要な場合
		// sodium、carbohydrateは不必要だがインスタンスの生成のため渋々0を渡している
		// NutritionFats cocaColaFats = new NutritionFats(240, 8, 1, 0, 0);

		// ビルダーパターンの場合、以下のようなスーパーな書き方ができる
		// コンストラクタの場合と比べて、どのオプションに値を格納しているかもわかりやすい
		NutritionFats fantaFats = new NutritionFats.Builder(200, 7).calories(110).build();


		MyPizza pizza = new MyPizza.Builder(SMALL)
				.addTopping(ONION)
				.addTopping(SAUSAGE)
				.build();

		Calzone calzone = new Calzone.Builder()
				.addTopping(HAM)
				.sauceInside()
				.build();

	}

}

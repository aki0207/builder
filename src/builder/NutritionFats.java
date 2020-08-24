package builder;

// ビルダーパターン
// コンストラクタのパラメータが多くなるとき、インスタンスを生成するときにそのとき不必要なフィールドにも
// 値を代入してインスタンスを生成する必要があるが、ビルダーパターンを使えば、必要になった任意のフィールド
// に値を入れた状態でインスタンスを生成できる
public class NutritionFats {

	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	public static class Builder {
		// 必須パラメータ
		private final int servingSize;
		private final int servings;

		// オプションデータ -デフォルト値に初期化
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrate = 0;

		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int val) {
			calories = val;
			return this;
		}

		public Builder fat(int val) {
			fat = val;
			return this;
		}

		public Builder sodium(int val) {
			sodium = val;
			return this;
		}

		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}

		public NutritionFats build() {
			// ここで必須の値のチェックをすべき
			return new NutritionFats(this);
		}
	}

	private NutritionFats(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
}

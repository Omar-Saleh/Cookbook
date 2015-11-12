class CreateRecipes < ActiveRecord::Migration
  def change
    create_table :recipes do |t|
      t.integer :user_id
      t.integer :post_id
      t.integer :votes
      t.string :description
      t.text :preparation

      t.timestamps null: false
    end
  end
end

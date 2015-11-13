class CreateComments < ActiveRecord::Migration
  def change
    create_table :comments do |t|
      t.integer :user_id
      t.integer :post_id
      t.text :content
      t.integer :likes

      t.timestamps null: false
    end
  end
end

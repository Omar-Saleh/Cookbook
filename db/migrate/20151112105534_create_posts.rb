class CreatePosts < ActiveRecord::Migration
  def change
    create_table :posts do |t|
      t.integer :user_id
      t.meta_data :pic

      t.timestamps null: false
    end
  end
end

class CreateStatuses < ActiveRecord::Migration
  def change
    create_table :statuses do |t|
      t.integer :user_id
      t.integer :post_id
      t.integer :likes
      t.string :description

      t.timestamps null: false
    end
  end
end

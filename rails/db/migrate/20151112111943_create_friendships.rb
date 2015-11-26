class CreateFriendships < ActiveRecord::Migration
  def change
    create_table :friendships do |t|
      t.integer :u1_id
      t.integer :u2_id
      t.boolean :accepted, default: false

      t.timestamps null: false
    end
  end
end

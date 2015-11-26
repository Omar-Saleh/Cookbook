class CreateFellowships < ActiveRecord::Migration
  def change
    create_table :fellowships do |t|
      t.integer :u1_id
      t.integer :u2_id

      t.timestamps null: false
    end
  end
end

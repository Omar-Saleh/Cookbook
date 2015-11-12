class CreateUsers < ActiveRecord::Migration
  def change
    create_table :users do |t|
      t.string :f_name
      t.string :l_name
      t.integer :age
      t.string :city
      t.string :country
      t.date :date_of_birth
      t.string :gender, limit: 1

      t.timestamps null: false
    end
  end
end

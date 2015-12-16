class AddUserNameToRecipes < ActiveRecord::Migration
  def change
  	add_column :recipes, :user_name, :string
  end
end

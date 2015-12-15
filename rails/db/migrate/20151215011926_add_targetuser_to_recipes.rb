class AddTargetUserToRecipes < ActiveRecord::Migration
  def change
  	add_column :recipes, :target_user, :integer
  end
end

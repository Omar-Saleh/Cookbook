class AddPictureToRecipies < ActiveRecord::Migration
  def change
    add_column :recipies, :picture, :string
  end
end

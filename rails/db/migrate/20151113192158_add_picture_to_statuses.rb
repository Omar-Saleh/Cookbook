class AddPictureToStatuses < ActiveRecord::Migration
  def change
    add_column :statuses, :picture, :string
  end
end

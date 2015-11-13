class Recipe < ActiveRecord::Base
	mount_uploader :picture, PictureUploader
	validates :description, :preparation, presence: true
end

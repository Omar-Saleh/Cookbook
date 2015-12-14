class Recipe < ActiveRecord::Base
	belongs_to :user
	has_many :comments, dependent: :destroy
	mount_uploader :picture, PictureUploader
	has_many :ingredients
	validates :description, :preparation, presence: true
	acts_as_commentable
	acts_as_votable
end

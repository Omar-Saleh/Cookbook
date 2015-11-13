class User < ActiveRecord::Base
	has_many :posts , dependent: :destroy
	has_many :comments, dependent: :destroy
	has_many :likes
	has_many :votes
end

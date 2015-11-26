class User < ActiveRecord::Base
	has_many :posts , dependent: :destroy
	has_many :comments, dependent: :destroy
	acts_as_voter
end

class User < ActiveRecord::Base
	has_many :posts , dependent: :destroy
	has_many :comments, dependent: :destroy
	acts_as_voter


	def pending_friends
		User.find_by_sql("Select * From users,friendships WHERE users.id = friendships.u2_id AND friendships.accepted = 0 AND friendships.u1_id = #{self.id}") |
		User.find_by_sql("Select * From users,friendships WHERE users.id = friendships.u1_id AND friendships.accepted = 0 AND friendships.u2_id = #{self.id}")
	end


	def friends
		User.find_by_sql("Select * From users,friendships WHERE users.id = friendships.u2_id AND friendships.accepted = 1 AND friendships.u1_id = #{self.id}") |
		User.find_by_sql("Select * From users,friendships WHERE users.id = friendships.u1_id AND friendships.accepted = 1 AND friendships.u2_id = #{self.id}")
	end
end
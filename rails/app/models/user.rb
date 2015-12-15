class User < ActiveRecord::Base
	has_many :posts , dependent: :destroy
	has_many :comments, dependent: :destroy
	acts_as_voter


	def timeline
		Recipe.find_by_sql("Select * From recipes,friendships WHERE friendships.accepted = 1 AND friendships.u1_id = #{self.id} AND recipes.user_id = friendships.u2_id") |
		Recipe.find_by_sql("Select * From recipes,friendships WHERE friendships.accepted = 1 AND friendships.u2_id = #{self.id} AND recipes.user_id = friendships.u1_id") |
		Recipe.find_by_sql("Select * From recipes WHERE recipes.user_id = #{self.id}")
	end



	def pending_friends
		User.find_by_sql("Select * From users,friendships WHERE users.id = friendships.u2_id AND friendships.accepted = 0 AND friendships.u1_id = #{self.id}").order(updated_at: :desc)
	end

	# Need to add a Third state for rejecting invites
	def friends_requests
		User.find_by_sql("Select * From users,friendships WHERE users.id = friendships.u1_id AND friendships.accepted = 0 AND friendships.u2_id = #{self.id}").order(updated_at: :desc)
	end

	def friends
		User.find_by_sql("Select * From users,friendships WHERE users.id = friendships.u2_id AND friendships.accepted = 1 AND friendships.u1_id = #{self.id}") |
		User.find_by_sql("Select * From users,friendships WHERE users.id = friendships.u1_id AND friendships.accepted = 1 AND friendships.u2_id = #{self.id}")
	end

	# def add_friend()
	# 	Friendship.where()
	# end
end
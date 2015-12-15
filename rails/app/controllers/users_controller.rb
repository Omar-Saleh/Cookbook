class UsersController < ApplicationController
	skip_before_filter  :verify_authenticity_token
	before_action :set_user, only:[:friends, :pending_friends, :posts, :timeline, :show, :add_friend, :remove_friend]
	respond_to :json


	def index
		render json: User.all.to_json
	end

	def new
		user = User.new	
	end

	def show
		render json: @user.to_json
	end

	def create

	end

	def friends
		render json: @user.friends.to_json
	end

	def pending_friends
		render json: @user.pending_friends.to_json
	end	

	def posts
		render json: Recipe.where(user_id: @user.id).order(updated_at: :desc).to_json
	end

	def timeline
		render json: @user.timeline.to_json
	end

	def friend_requests
		render json: @user.friend_requests.to_json
	end

	# def add_friend
	# 	respond_with @user.add_friend
	# end

	# def remove_friend
	# 	respond_with @user.remove_friend
	# end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_user
      @user = User.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def user_params
      params.require(:user).permit(:name, :password)
    end

end

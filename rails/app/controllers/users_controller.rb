class UsersController < ApplicationController
	before_action :set_user, only:[:friends, :pending_friends, :posts]
	respond_to :json


	def index
		respond_with @users = User.all
	end

	def new
		user = User.new	
	end

	def show
	end

	def create

	end

	def friends
		respond_with @users = @user.friends
	end

	def pending_friends
		respond_with @users = @user.pending_friends
	end

	def posts
		respond_with @recipes = Recipe.where(user_id: @user.id)
	end

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

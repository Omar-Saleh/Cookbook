class RecipesController < ApplicationController
	respond_to :json
	skip_before_filter  :verify_authenticity_token
	before_action :set_post, only: [:comments, :show]

	def index
		respond_with @recipes = Recipe.all.order(created_at: :desc)
	end

	def show
		respond_with @recipe
	end

	def create
		@recipe = Recipe.new(recipe_params)
		@recipe.save
		respond_with @recipe
	end

	def comments
		respond_with @recipe.root_comments
	end


private
    # Use callbacks to share common setup or constraints between actions.

    def set_post
    	@recipe = Recipe.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def recipe_params
      params.require(:recipe).permit(:name, :description, :preparation, :target_user)
    end

end